describe('Pregled in sprememba podatkov', function () {
    it('Obisk profila in spreminjanje', function () {
        cy.visit('http://localhost:4200/login')

        cy.url()
            .should('include', '/login')

        cy.get('.email')
            .type('testko')
            .should('have.value', 'testko')

        cy.get('.password')
            .type('test')
            .should('have.value', 'test')

        cy.get('.btn-primary')
            .click()
        cy.wait(500)

        cy.get('a').contains('Profil')
            .click()

        cy.get('.btn').contains('Uredi profil')
            .click()

        cy.get('input[name="name"]')
            .clear()
            .type('Novo ime')
            .should('have.value', 'Novo ime')

        cy.get('.btn').contains('Spremeni')
            .click()

        cy.wait(500)

        cy.get('h1').contains('Novo ime Testko')


    });
});

describe('Dodajanje nove storitve z napako', function () {
    it('Obisk strani za dodajanje in dodajenje', function () {
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

        cy.get('.btn').contains('Uporabniki')
            .click()
        cy.wait(500)

        cy.get('.btn').contains(' Pošlji sporočilo uporabniku ')
            .click()

        cy.get('input[name="ime"]')
            .type('Pozdravljen pasjehodec')
            .should('have.value', 'Pozdravljen pasjehodec')

        cy.get('.btn').contains(' Pošlji sporočilo ')
            .click()
        cy.wait(500)


        cy.get('h1').contains('Sporočilo je bilo poslano')
    });
});
